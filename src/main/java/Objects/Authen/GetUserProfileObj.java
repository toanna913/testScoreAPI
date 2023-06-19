package Objects.Authen;

public class GetUserProfileObj {
    public static String GetUserProfileObj (){

        String requestbody = "{\n" +
                " \"queue\": \"ha_qu_core-service_user-profile\"\n" +
                "}";
        return requestbody;
    }
}
