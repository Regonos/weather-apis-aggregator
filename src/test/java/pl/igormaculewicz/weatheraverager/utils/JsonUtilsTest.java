package pl.igormaculewicz.weatheraverager.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class JsonUtilsTest {

    @Nested
    class WhenFindingRecursively {
        private final String JSON_STRING = "{\"request\":{\"type\":\"City\",\"query\":\"Szczecin, Poland\",\"language\":\"en\",\"unit\":\"m\"},\"location\":{\"name\":\"Szczecin\",\"country\":\"Poland\",\"region\":\"\",\"lat\":\"53.417\",\"lon\":\"14.583\",\"timezone_id\":\"Europe\\/Warsaw\",\"localtime\":\"2020-10-09 20:24\",\"localtime_epoch\":1602275040,\"utc_offset\":\"2.0\"},\"current\":{\"observation_time\":\"06:24 PM\",\"temperature\":11,\"weather_code\":116,\"weather_icons\":[\"https:\\/\\/assets.weatherstack.com\\/images\\/wsymbols01_png_64\\/wsymbol_0002_sunny_intervals.png\"],\"weather_descriptions\":[\"Partly cloudy\"],\"wind_speed\":9,\"wind_degree\":140,\"wind_dir\":\"SE\",\"pressure\":1017,\"precip\":0.1,\"humidity\":87,\"cloudcover\":25,\"feelslike\":10,\"uv_index\":3,\"visibility\":10,\"is_day\":\"yes\"}}";
        private final String PATH = "request.type";

        @Test
        void existingKeyInJson_shouldReturnGivenValueOfKey() {
            String result = JsonUtils.findRecursively(JSON_STRING, PATH);
            assertThat(result).isEqualTo("City");
        }

        @Test
        void notExistingKeyInJson_shouldReturnNull() {
            String result = JsonUtils.findRecursively(JSON_STRING, "sdsdadas" + PATH);
            assertThat(result).isNull();
        }
    }
}