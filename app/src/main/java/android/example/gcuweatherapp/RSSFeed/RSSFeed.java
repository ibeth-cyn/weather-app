package android.example.gcuweatherapp.RSSFeed;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.ArrayRes;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RSSFeed extends AsyncTask<String, Void, HashMap<String,ArrayList<Weather>>>{

    String BASE_URL = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    ArrayList<Weather> newItem;
    Exception exception = null;

    Context c;

    HashMap<String, String> mapLocationID= new HashMap<String, String>() {{
        put("Glasgow", "2648579");
        put("London", "2643743");
        put("New York", "5128581");
        put("Muscat", "287286");
        put("Port Louis", "934154");
        put("Dhaka", "1185241");
        put("Lagos", "2332459");
    }};
    InputUrl newInput = new InputUrl();
    //TODO: removed hashmap here

    public RSSFeed(Context c) {
        this.c = c;
    }

    @Override
    protected HashMap<String,ArrayList<Weather>> doInBackground(String... strings) {

        //TODO: removed newItem here -f
        HashMap<String,ArrayList<Weather>> list = new HashMap<>();

        for (String loc : mapLocationID.keySet()) {

            newItem = new ArrayList<Weather>();
            String locationID = mapLocationID.get(loc);

            try {
                Weather item = null;
                URL url = new URL(BASE_URL + locationID);
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);

                XmlPullParser xpp = factory.newPullParser();

                xpp.setInput(newInput.getInputStream(url), "UTF_8");

                boolean insideItem = false;

                int eventType = xpp.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    if (eventType == XmlPullParser.START_TAG) {
                        if (xpp.getName().equalsIgnoreCase("item")) {
                            insideItem = true;
                            item = new Weather();
                        } else if (xpp.getName().equalsIgnoreCase("title")) {
                            if (insideItem) {
                                item.setTitle(xpp.nextText());
                            }
                        } else if (xpp.getName().equalsIgnoreCase(("description"))) {
                            if (insideItem) {
                                item.setDescription(xpp.nextText());
                            }
                        } else if (xpp.getName().equalsIgnoreCase(("pubDate"))) {
                            if (insideItem) {
                                String pubDate = xpp.nextText().substring(0,16);
                                item.setPublicationDate(pubDate);
                            }
                        }
                    } else if (eventType == XmlPullParser.END_TAG && xpp.getName().equalsIgnoreCase("item")) {
                        insideItem = false;
                        newItem.add(item);
                        list.put(loc,newItem);
                    }
                    eventType = xpp.next();
                }
            } catch (MalformedURLException e) {
                exception = e;
            } catch (XmlPullParserException e) {
                exception = e;
            } catch (IOException e) {
                exception = e;
            }

        }
        return list;

    }

    @Override
    protected void onPostExecute(HashMap<String, ArrayList<Weather>> stringArrayListHashMap) {
        super.onPostExecute(stringArrayListHashMap);

        String key;

        for(HashMap.Entry<String, ArrayList<Weather>> entry : stringArrayListHashMap.entrySet()){

            key = entry.getKey();
            ArrayList<Weather> arrayList = stringArrayListHashMap.get(key);

            //Loop through array list to get weather objects, call split method on object
            for(int i  = 0; i< arrayList.size(); i++){
                Weather weather = arrayList.get(i);
                weather.splitValues(weather.getTitle(), weather.getDescription());
            }

            System.out.println("GGGGGGGGGGGGGGGGGGGGGG" + " " + " ---CITY--- "+ key + " " + arrayList.get(0).toString());
        }

    }
}

