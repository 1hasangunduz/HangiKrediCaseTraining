package BasePages;


import Utilities.Log;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;

import java.io.File;


@Data
public final class DriverConfig {

    private static DriverConfig instance;
    private boolean chromeHeadless;
    private boolean mobileHeadless;
    private boolean firefoxHeadless;

    private DriverConfig() {
    }

    public static DriverConfig getInstance() {
        if (instance == null) {
            try {
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                instance = mapper.readValue(new File("src/main/resources/driverConfig.yaml"), DriverConfig.class);
            } catch (Exception e) {
                Log.pass("driverConfig dosyasi okunurken hata alindi!");
            }
        }

        return instance;
    }

}