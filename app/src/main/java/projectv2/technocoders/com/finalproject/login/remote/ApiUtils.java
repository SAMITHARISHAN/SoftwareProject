package projectv2.technocoders.com.finalproject.login.remote;

/**
 * Created by acer on 12/22/2017.
 */

public class ApiUtils {
    private ApiUtils() {}
    public static final String BASE_URL= "http://technocoders.azurewebsites.net/Api/";

    public static UserService getUserService(){
        return RetrofitClient.getClient(BASE_URL).create(UserService.class);
    }
}

