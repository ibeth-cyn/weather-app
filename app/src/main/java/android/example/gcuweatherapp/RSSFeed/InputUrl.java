package android.example.gcuweatherapp.RSSFeed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InputUrl {

    URL url;

    public InputUrl(){
        this.url = url;
    }

    public InputStream getInputStream(URL url){
        try{
            return url.openConnection().getInputStream();
        }catch(IOException e){
            return null;
        }
    }

}
