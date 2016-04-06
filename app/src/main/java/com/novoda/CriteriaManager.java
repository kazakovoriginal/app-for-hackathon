package com.novoda;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;

public class CriteriaManager{
    private static ArrayList<Season> allSeasons = new ArrayList<Season>();
    private static ArrayList<Type> allTypes = new ArrayList<Type>();
    private static ArrayList<ActivityCrit> allActivities = new ArrayList<ActivityCrit>();
    private static ArrayList<Country> allCountries = new ArrayList<Country>();
    private static ArrayList<City> allCities = new ArrayList<City>();

    private static ArrayList<Season> selectedSeasons = new ArrayList<Season>();
    private static ArrayList<Type> selectedTypes = new ArrayList<Type>();
    private static ArrayList<ActivityCrit> selectedActivities = new ArrayList<ActivityCrit>();
    private static ArrayList<Country> selectedCountries = new ArrayList<Country>();
    private static ArrayList<City> selectedCities = new ArrayList<City>();

    private static String filename;

    public static void setFile(String f) {
        filename = f;
    }

    /**
     *
     * @param type Название критерия из файла json
     * @param values ID этого критерия.
     * @throws IOException
     */
    public static void select(String type, int... values) {
        switch (type) {
            case "seasons":
                selectSeasons(values);
                    break;
            case "type":
                selectTypes(values);
                break;
            case "activities":
                selectActivities(values);
                break;
            case "countries":
                selectCountries(values);
                break;
            case "cities":
                selectCities(values);
                break;
        }
    }

    public static void disselect(String type) {
        switch (type) {
            case "seasons":
                selectedSeasons = allSeasons;
            case "type":
                selectedTypes = allTypes;
                break;
            case "activities":
                selectedActivities = allActivities;
                break;
            case "countries":
                selectedCountries = allCountries;
                break;
            case "cities":
                selectedCities = allCities;
                break;
        }
    }

    public static void parseAllFromFile() {
        try {
            parseFromFile("seasons");
            parseFromFile("countries");
            parseFromFile("type");
            parseFromFile("activities");
            parseFromFile("cities");
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void parseFromFile(String type) throws Exception {
        if(type.equals("seasons")) {
            parseSeasons();
            return;
        }

//araz
//        File file1 = new File("/Users/andreykazakov/AndroidStudioProjects/MyApplication/app/src/main/assets/test.json");
//        InputStream in = null;
//        in = new BufferedInputStream(new FileInputStream(file1));



        String json = "{\n" +
                "  \"countries\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"Канада\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Бельгия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Германия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"name\": \"Финляндия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 4,\n" +
                "      \"name\": \"Великобритания\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 5,\n" +
                "      \"name\": \"Нидерланды\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 6,\n" +
                "      \"name\": \"Ирландия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 7,\n" +
                "      \"name\": \"Исландия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 8,\n" +
                "      \"name\": \"Австрия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 9,\n" +
                "      \"name\": \"Италия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 10,\n" +
                "      \"name\": \"Турция\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 11,\n" +
                "      \"name\": \"Чили\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 12,\n" +
                "      \"name\": \"Россия\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\":13,\n" +
                "      \"name\": \"США\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 14,\n" +
                "      \"name\": \"Австралия\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"type\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"typeName\": \"Активный отдых\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"typeName\": \"Здоровье\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 2,\n" +
                "      \"typeName\": \"Пляжный отдых\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": 3,\n" +
                "      \"typeName\": \"Туризм\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"activities\": [\n" +
                "    {\n" +
                "      \"actName\": \"Зимний спорт\",\n" +
                "      \"id\": 0,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [0]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Водный спорт\",\n" +
                "      \"id\": 1,\n" +
                "      \"typeId\":0,\n" +
                "      \"seasonId\": [1]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Горячие источники\",\n" +
                "      \"id\": 2,\n" +
                "      \"typeId\": 1,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Горные походы\",\n" +
                "      \"id\": 3,\n" +
                "      \"typeId\": 1,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Купание\",\n" +
                "      \"id\": 4,\n" +
                "      \"typeId\": 2,\n" +
                "      \"seasonId\": [1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Пляжные развлечения\",\n" +
                "      \"id\": 5,\n" +
                "      \"typeId\": 2,\n" +
                "      \"seasonId\": [1]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Музеи\",\n" +
                "      \"id\": 6,\n" +
                "      \"typeId\": 3,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Исторические места\",\n" +
                "      \"id\": 7,\n" +
                "      \"typeId\": 3,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Альпинизм\",\n" +
                "      \"id\": 8,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Рафтинг\",\n" +
                "      \"id\": 9,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Дайвинг\",\n" +
                "      \"id\": 10,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [1]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Сафари парк\",\n" +
                "      \"id\": 11,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"СПА\",\n" +
                "      \"id\": 12,\n" +
                "      \"typeId\": 1,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Специальные оздоровительные программы\",\n" +
                "      \"id\": 13,\n" +
                "      \"typeId\": 1,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Экзотика\",\n" +
                "      \"id\": 14,\n" +
                "      \"typeId\": 3,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Водные прогулки\",\n" +
                "      \"id\": 15,\n" +
                "      \"typeId\": 2,\n" +
                "      \"seasonId\": [1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Национальная кухня\",\n" +
                "      \"id\": 16,\n" +
                "      \"typeId\": 2,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Архитектура\",\n" +
                "      \"id\": 17,\n" +
                "      \"typeId\": 3,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Велосипедные прогулки\",\n" +
                "      \"id\": 18,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Рыбалка\",\n" +
                "      \"id\": 19,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    },\n" +
                "    {\n" +
                "      \"actName\": \"Пешие походы\",\n" +
                "      \"id\": 20,\n" +
                "      \"typeId\": 0,\n" +
                "      \"seasonId\": [0,1,2]\n" +
                "    }\n" +
                "\n" +
                "  ],\n" +
                "  \"cities\": [\n" +
                "    {\n" +
                "      \"countryId\": 0,\n" +
                "      \"id\": 0,\n" +
                "      \"latitude\": 49.15278,\n" +
                "      \"longitude\": -121.93889,\n" +
                "      \"name\": \"`Чиллиуок\",\n" +
                "      \"summer\": [3,20,19,14,18],\n" +
                "      \"winter\": [19,20,14,3],\n" +
                "      \"other\": [3,20,19,14,18],\n" +
                "      \"description\": \"город в Британской Колумбии, Канада. Находится в 100км от столицы - Ванкувера. Живописный ландшафт, озера и прекрасный климат - все, что нужно для хорошего отдыха.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 1,\n" +
                "      \"id\": 1,\n" +
                "      \"latitude\": 51.189445,\n" +
                "      \"longitude\": 4.460278,\n" +
                "      \"name\": \"Антверпен\",\n" +
                "      \"summer\": [17,6],\n" +
                "      \"winter\": [6,17],\n" +
                "      \"other\": [6,17],\n" +
                "      \"description\" : \"Город во Фламандском регионе Бельгии. Красивая архитектура, атмосфера старого города и великолепные водные прогулки.\"\n" +
                "\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 2,\n" +
                "      \"id\": 2,\n" +
                "      \"latitude\": 52.38,\n" +
                "      \"longitude\": 13.5225,\n" +
                "      \"name\": \"Берлин\",\n" +
                "      \"summer\": [17,7,6],\n" +
                "      \"winter\": [17,7,6],\n" +
                "      \"other\": [17,7,6],\n" +
                "      \"description\" : \"Столица Германии, самый крупный и самый населённый город страны. Множество музеев, соборов, а также возможность оценить местное пиво и знаменитые колбаски.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 2,\n" +
                "      \"id\": 346,\n" +
                "      \"latitude\": 50.707657,\n" +
                "      \"longitude\": 8.082969,\n" +
                "      \"name\": \"Зигерланд\",\n" +
                "      \"summer\": [19,20],\n" +
                "      \"winter\": [],\n" +
                "      \"other\": [19,20],\n" +
                "      \"description\" : \"Прекрасное место для отдыха на природе.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 2,\n" +
                "      \"id\": 366,\n" +
                "      \"latitude\": 47.671318,\n" +
                "      \"longitude\": 9.511486,\n" +
                "      \"name\": \"Фридрихсхафен\",\n" +
                "      \"summer\": [17,6,15],\n" +
                "      \"winter\": [17,6],\n" +
                "      \"other\": [17,6,15],\n" +
                "      \"description\" : \"Город в Германии на берегу Боденского озера. Водные экскурсии и замечательные виды - вот, что ждет вас здесь.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 3,\n" +
                "      \"id\": 407,\n" +
                "      \"latitude\": 60.654446,\n" +
                "      \"longitude\": 24.881111,\n" +
                "      \"name\": \"Хювинкяа\",\n" +
                "      \"summer\": [20,18,12,13],\n" +
                "      \"winter\": [20,12,13],\n" +
                "      \"other\": [20,18,12,13],\n" +
                "      \"description\" : \"Город в Финляндии в 50км от Хельсинки. Прекрасное место для оздоровительного отдыха.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 4,\n" +
                "      \"id\": 473,\n" +
                "      \"latitude\": 51.87472,\n" +
                "      \"longitude\": -0.368333,\n" +
                "      \"name\": \"Лондон\",\n" +
                "      \"summer\": [6,7,17,16],\n" +
                "      \"winter\": [6,7,17,16],\n" +
                "      \"other\": [6,7,17,16],\n" +
                "      \"description\" : \"Столица Великобритании предлагает вам различные виды отдыха от осмотра достопримечательностей до посещения местных пабов и футбольных стадионов.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 4,\n" +
                "      \"id\": 474,\n" +
                "      \"latitude\": 50.42278,\n" +
                "      \"longitude\": -4.105833,\n" +
                "      \"name\": \"Плимут\",\n" +
                "      \"summer\": [6,15,17],\n" +
                "      \"winter\": [6,17],\n" +
                "      \"other\": [6,15,17],\n" +
                "      \"description\" : \"Город в Англии на берегу Ла-Манша. Здесь находится известный музей автомобилей.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 5,\n" +
                "      \"id\": 555,\n" +
                "      \"latitude\": 52.308613,\n" +
                "      \"longitude\": 4.763889,\n" +
                "      \"name\": \"Амстердам\",\n" +
                "      \"summer\": [6,14,15,16,17,18],\n" +
                "      \"winter\": [6,14,16,17,18],\n" +
                "      \"other\": [6,14,15,16,17,18],\n" +
                "      \"description\" : \"Столица Нидерландов. Город возможностей и соблазнов.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 6,\n" +
                "      \"id\": 578,\n" +
                "      \"latitude\": 54.280212,\n" +
                "      \"longitude\": -8.599206,\n" +
                "      \"name\": \"Слайго\",\n" +
                "      \"summer\": [3,14,19,20],\n" +
                "      \"winter\": [3,14,19,20],\n" +
                "      \"other\": [3,14,19,20],\n" +
                "      \"description\" : \"Местечко на востоке Ирландии. Здесь представлены все виды отдыха на природе.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 7,\n" +
                "      \"id\": 17,\n" +
                "      \"latitude\": 64.13,\n" +
                "      \"longitude\": -21.940556,\n" +
                "      \"name\": \"Рейкьявик\",\n" +
                "      \"summer\": [2,12,16,17,20],\n" +
                "      \"winter\": [2,12,16,17,20],\n" +
                "      \"other\": [2,12,16,17,20],\n" +
                "      \"description\" : \"Столица Исландии. Знаменитые горячие источники и невероятная красота природы.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 8,\n" +
                "      \"id\": 1507,\n" +
                "      \"latitude\": 47.26022,\n" +
                "      \"longitude\": 11.343964,\n" +
                "      \"name\": \"Инсбрук\",\n" +
                "      \"summer\": [3,8,20,17],\n" +
                "      \"winter\": [0,3,8,20,17],\n" +
                "      \"other\": [0,3,8,20,17],\n" +
                "      \"description\" : \"Австрийский горнолыжный курорт. Столица зимних олимпийских игр 1964 года.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 9,\n" +
                "      \"id\": 1454,\n" +
                "      \"latitude\": 41.799362,\n" +
                "      \"longitude\": 12.594936,\n" +
                "      \"name\": \"Рим\",\n" +
                "      \"summer\": [17,6,7,16],\n" +
                "      \"winter\": [17,6,7,16],\n" +
                "      \"other\": [17,6,7,16],\n" +
                "      \"description\" : \"Столица Италии. С каждым новым шагом вы окунаетесь в историю великой Римской империи.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 10,\n" +
                "      \"id\": 1579,\n" +
                "      \"latitude\": 36.89873,\n" +
                "      \"longitude\": 30.80046,\n" +
                "      \"name\": \"Анталия\",\n" +
                "      \"summer\": [1,5,4,12,10,16],\n" +
                "      \"winter\": [],\n" +
                "      \"other\": [1,5,4,12,10,16],\n" +
                "      \"description\" : \"Столица мирового пляжного отдыха.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 11,\n" +
                "      \"id\": 1633,\n" +
                "      \"latitude\": 17.928982,\n" +
                "      \"longitude\": -71.64477,\n" +
                "      \"name\": \"Кабо Рохо\",\n" +
                "      \"summer\": [1,4,14,10,20],\n" +
                "      \"winter\": [1,4,14,10,20],\n" +
                "      \"other\": [1,4,14,10,20],\n" +
                "      \"description\" : \"Местечко на западном побережье Чили. Одно из красивейших мест на нашей планете.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 12,\n" +
                "      \"id\": 2703,\n" +
                "      \"latitude\": 43.44993,\n" +
                "      \"longitude\": 39.95659,\n" +
                "      \"name\": \"Сочи\",\n" +
                "      \"summer\": [1,3,5,4,10,15,18,20],\n" +
                "      \"winter\": [0,12],\n" +
                "      \"other\": [3,12,20],\n" +
                "      \"description\" : \"Российская столица активного и пляжного отдыха. Горные лыжи и сноуборд - зимой, купание и пляжи - летом\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 12,\n" +
                "      \"id\": 3222,\n" +
                "      \"latitude\": 27.765112,\n" +
                "      \"longitude\": -82.62697,\n" +
                "      \"name\": \"Санкт-Петербург\",\n" +
                "      \"summer\": [6,7,15,17],\n" +
                "      \"winter\": [6,7,17],\n" +
                "      \"other\": [6,7,15,17],\n" +
                "      \"description\" : \"Один из красивейших городов России. Прогулки по реке, разводные мосты и красивейшие соборы.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 13,\n" +
                "      \"id\": 3264,\n" +
                "      \"latitude\": 32.69922,\n" +
                "      \"longitude\": -117.21531,\n" +
                "      \"name\": \"Сан Диего\",\n" +
                "      \"summer\": [11,17,18],\n" +
                "      \"winter\": [11,17,18],\n" +
                "      \"other\": [11,17,18],\n" +
                "      \"description\" : \"Город в США. Здесь расположен один из крупнейших Сафари парков мира.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 12,\n" +
                "      \"id\": 2700,\n" +
                "      \"latitude\": 44.22507,\n" +
                "      \"longitude\": 43.08189,\n" +
                "      \"name\": \"Минеральные воды\",\n" +
                "      \"summer\": [9,3,8,20,19],\n" +
                "      \"winter\": [9,3,8,20,19,0],\n" +
                "      \"other\": [9,3,8,20,19],\n" +
                "      \"description\" : \"Город входит в состав эколого-курортного региона Кавказа. Здесь представлены различные виды активного отдыха от рафтинга до горных лыж.\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"countryId\": 14,\n" +
                "      \"id\": 5151,\n" +
                "      \"latitude\": 47.706944,\n" +
                "      \"longitude\": -104.1925,\n" +
                "      \"name\": \"Сидней\",\n" +
                "      \"summer\": [1,4,17],\n" +
                "      \"winter\": [1,4,17],\n" +
                "      \"other\": [1,4,17],\n" +
                "      \"description\" : \"Крупнейший город в Австралии. Здесь можно встретить как памятники архитектуры, так и места для купания и пляжного отдыха.\"\n" +
                "    }\n" +
                "\n" +
                "  ]\n" +
                "}\n" +
                "\t\n" +
                "\t\n" +
                "\t";

                BufferedReader br = new BufferedReader(new StringReader(json));
        boolean done = false;
        while(br.ready() && !done) {  //Проходим по всему файлу
            String line = br.readLine();
            if(line.endsWith("\""+type+"\": [")) { //Находим критерий
                while (!line.endsWith("}")) { // Если закрвающаяся скобка без запятой, значит это конец критерия
                    String entry = "";
                    while (!entry.contains("},") && !entry.contains("}")) { //Считываем строку пока не попадем на закрывающую скобку
                        entry += br.readLine();
                    }
                    switch (type) {
                        case "type":
                            getJsonTypes(entry);
                            break;
                        case "activities":
                            getJsonActivities(entry);
                            break;
                        case "countries":
                            getJsonCountries(entry);
                            break;
                        case "cities":
                            getJsonCities(entry);
                            break;
                    }
                    line += entry;
                }
                done = true;
            }
        }
        br.close();
    }

    private static void parseSeasons() {
        allSeasons.add(new Season(0,"Зимой"));
        allSeasons.add(new Season(1,"Летом"));
        allSeasons.add(new Season(2,"Весной или осенью"));
        selectedSeasons.add(new Season(0,"Зимой"));
        selectedSeasons.add(new Season(1,"Летом"));
        selectedSeasons.add(new Season(2,"Весной или осенью"));


    }

    private static void selectSeasons(int... values) {
        if(values.length == 0)
            return;

        Iterator<Season> it = selectedSeasons.iterator();
        while(it.hasNext()) {
            Season s = it.next();
            boolean valid = false;
            for (int i = 0; i < values.length; i++) {
                if(s.getId() == values[i]) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                it.remove();
        }
    }

    private static void selectTypes(int... values) {
        if(values.length == 0)
            return;

        Iterator<Type> it = selectedTypes.iterator();
        while(it.hasNext()) {
            Type t = it.next();
            boolean valid = false;
            for (int i = 0; i < values.length; i++) {
                if(t.getId() == values[i]) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                it.remove();
        }
    }

    private static void preselectActivities() {
            Iterator<ActivityCrit> it = selectedActivities.iterator();
            while (it.hasNext()) {
                    ActivityCrit a = it.next();
                    for (int i = 0; i < selectedSeasons.size(); i++) {
                            if (!a.getSeasid().contains(selectedSeasons.get(i).getId())) {
                                    it.remove();
                            }
                    }
            }
        Iterator<ActivityCrit> ita = selectedActivities.iterator();
        while(ita.hasNext()) {
            ActivityCrit a = ita.next();
            boolean valid = false;
            for (int i = 0; i < selectedTypes.size(); i++) {
                if(selectedTypes.get(i).getId() == a.getTypeId()) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                ita.remove();
        }
    }

    private static void selectActivities(int... values) {
        preselectActivities();
        if(values.length == 0)
            return;

        Iterator<ActivityCrit> it = selectedActivities.iterator();
        while(it.hasNext()) {
            ActivityCrit a = it.next();
            boolean valid = false;
            for (int i = 0; i < values.length; i++) {
                if(a.getId() == values[i]) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                it.remove();
        }
    }

    private static void selectCountries(int... values) {
        Iterator<Country> it = selectedCountries.iterator();
        while(it.hasNext()) {
            Country c = it.next();
            boolean valid = false;
            for (int i = 0; i < values.length; i++) {
                if(c.getId() == values[i]) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                it.remove();
        }
    }

    private static void preSelectCities() {
        Iterator<City> itc = selectedCities.iterator();
        while(itc.hasNext()) {
            City ci = itc.next();
            boolean valid = false;
            for (int i = 0; i < selectedCountries.size(); i++) {
                if(selectedCountries.get(i).getId() == ci.getCountryId()) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                itc.remove();
        }
        itc = selectedCities.iterator();
        while(itc.hasNext()) {
            City ci = itc.next();
            boolean valid = true;
    out:    for (int i = 0; i < selectedSeasons.size(); i++) {
                if(selectedSeasons.get(i).getName().equals("summer")) {
                    for (int j = 0; j < selectedActivities.size(); j++) {
                        if(!ci.getSummer().contains(selectedActivities.get(j).getId())) {
                            valid = false;
                            break;
                        } else {
                            valid = true;
                            break out;
                        }
                    }
                } else if(selectedSeasons.get(i).getName().equals("winter")) {
                    for (int j = 0; j < selectedActivities.size(); j++) {
                        if(!ci.getWinter().contains(selectedActivities.get(j).getId())) {
                            valid = false;
                            break;
                        } else {
                            valid = true;
                            break out;
                        }
                    }
                } else if(selectedSeasons.get(i).getName().equals("other")) {
                    for (int j = 0; j < selectedActivities.size(); j++) {
                        if(!ci.getOther().contains(selectedActivities.get(j).getId())) {
                            valid = false;
                            break;
                        } else {
                            valid = true;
                            break out;
                        }
                    }
                }
            }
            if(!valid)
                itc.remove();
        }
    }

    private static void selectCities(int... values) {
        preSelectCities();
        if(values.length == 0)
            return;

        Iterator<City> it = selectedCities.iterator();
        while(it.hasNext()) {
            City ci = it.next();
            boolean valid = false;
            for (int i = 0; i < values.length; i++) {
                if(ci.getId() == values[i]) {
                    valid = true;
                    break;
                }
            }
            if(!valid)
                it.remove();
        }
    }

    private static void getJsonTypes(String s) throws Exception{
        JSONObject o = new JSONObject(s);
        int id = o.getInt("id");
        String name = o.getString("typeName");

        allTypes.add(new Type(id, name));
        selectedTypes.add(new Type(id, name));
    }

    private static void getJsonActivities(String s) throws Exception{
        JSONObject o = new JSONObject(s);
        String name = o.getString("actName");
        int id = o.getInt("id");
        int typeId = o.getInt("typeId");

            JSONArray a = o.getJSONArray("seasonId");
            ArrayList<Integer> sid = new ArrayList<>();
            for(int i = 0; i < a.length(); i++) {
                    sid.add(a.getInt(i));
            }

            allActivities.add(new ActivityCrit(id, name, typeId,sid));
            selectedActivities.add(new ActivityCrit(id, name, typeId,sid));
    }

    private static void getJsonCountries(String s) throws Exception{
        JSONObject o = new JSONObject(s);
        int id = o.getInt("id");
        String name = o.getString("name");

        allCountries.add(new Country(id, name));
        selectedCountries.add(new Country(id, name));
    }

    private static void getJsonCities(String s) throws Exception{
        JSONObject o = new JSONObject(s);
        int countryId = o.getInt("countryId");
        int id = o.getInt("id");
        double lat = o.getDouble("latitude");
        double longit = o.getDouble("longitude");
        String name = o.getString("name");
        JSONArray su = o.getJSONArray("summer");
        JSONArray w = o.getJSONArray("winter");
        JSONArray oth = o.getJSONArray("other");
        String description = o.getString("description");

        ArrayList<Integer> summer = new ArrayList<>();
        for (int i = 0; i < su.length(); i++)
            summer.add(su.getInt(i));

        ArrayList<Integer> winter = new ArrayList<>();
        for (int i = 0; i < w.length(); i++)
            winter.add(w.getInt(i));

        ArrayList<Integer> other = new ArrayList<>();
        for (int i = 0; i < oth.length(); i++)
            other.add(oth.getInt(i));

        allCities.add(new City(id, countryId, name, lat, longit, summer, winter, other, description));
        selectedCities.add(new City(id, countryId, name, lat, longit, summer, winter, other, description));
    }

    public static ArrayList<Season> getSelectedSeasons() {
        return selectedSeasons;
    }

    public static ArrayList<Type> getSelectedTypes() {
        return selectedTypes;
    }

    public static ArrayList<ActivityCrit> getSelectedActivities() {
        return selectedActivities;
    }

    public static ArrayList<Country> getSelectedCountries() {
        return selectedCountries;
    }

    public static ArrayList<City> getSelectedCities() {
        return selectedCities;
    }
}
