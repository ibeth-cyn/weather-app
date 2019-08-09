package android.example.gcuweatherapp.RSSFeed;

import android.content.Context;
import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RSSFeed extends AsyncTask<String, Void, HashMap<String,ArrayList<RSSItemClass>>>{

    String BASE_URL = "https://weather-broker-cdn.api.bbci.co.uk/en/forecast/rss/3day/";
    ArrayList<RSSItemClass> newItem;
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
    protected HashMap<String,ArrayList<RSSItemClass>> doInBackground(String... strings) {

        //TODO: removed newItem here -f
        HashMap<String,ArrayList<RSSItemClass>> list = new HashMap<>();

        for (String loc : mapLocationID.keySet()) {

            newItem = new ArrayList<RSSItemClass>();
            String locationID = mapLocationID.get(loc);

            try {
                RSSItemClass item = null;
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
                            item = new RSSItemClass();
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

        System.out.println(list.get("Port Louis").get(0).toString());
        return list;

    }

    @Override
    protected void onPostExecute(HashMap<String, ArrayList<RSSItemClass>> stringArrayListHashMap) {
        super.onPostExecute(stringArrayListHashMap);

        System.out.println("--------------NIGERIA -----------");
        System.out.println(stringArrayListHashMap.get("Lagos").get(0).toString());

    }
}

