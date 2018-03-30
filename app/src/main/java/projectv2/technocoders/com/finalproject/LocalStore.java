package projectv2.technocoders.com.finalproject;

import android.content.Context;
import android.content.SharedPreferences;

import projectv2.technocoders.com.finalproject.login.model.ResObj;

/**
 * Created by DELL on 1/30/2018.
 * All Rights Reserved by MLPJ©
 */

public class LocalStore {


    public  final static String spName = "userDetails";
    SharedPreferences userLocalDatabase;

    public LocalStore(Context context){
        userLocalDatabase = context.getSharedPreferences(spName,0);

    }

    public void setUserDetails(ResObj user){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("eId", user.getEID());
        spEditor.putString("password", user.getPassword());
        spEditor.putString("email", user.getEmail());
        spEditor.putBoolean("emailVarified", user.getEmailVerified());
        spEditor.putString("activationCode", user.getActivationCode());
        spEditor.putString("dob", user.getDob());
        spEditor.putString("fName", user.getFName());
        spEditor.putString("lName", user.getLName());
        spEditor.putString("gender", user.getGender());
        spEditor.putString("homeNo", user.getHomeNo());
        spEditor.putString("street", user.getStreet());
        spEditor.putString("city", user.getCity());
        spEditor.putString("jobCategory", user.getJobCategory());
        spEditor.putString("managerId", user.getManagerId());

        spEditor.commit();
    }

    public ResObj getUserDetails(){
        String eid = userLocalDatabase.getString("eId","");
        String password = userLocalDatabase.getString("password","");
        String email = userLocalDatabase.getString("email","");
        boolean emailVarified = userLocalDatabase.getBoolean("emailVarified",false);
        String activationCode = userLocalDatabase.getString("activationCode","");
        String dob = userLocalDatabase.getString("dob","");
        String fName = userLocalDatabase.getString("fName","");
        String lName = userLocalDatabase.getString("lName","");
        String gender = userLocalDatabase.getString("gender","");
        String homeNo = userLocalDatabase.getString("homeNo","");
        String street = userLocalDatabase.getString("street","");
        String city = userLocalDatabase.getString("city","");
        String jobCategory = userLocalDatabase.getString("jobCategory","");
        String managerId = userLocalDatabase.getString("managerId","");

        ResObj user =new ResObj(eid,password,email,emailVarified,activationCode,dob,fName,lName,gender,homeNo,street,city,jobCategory,managerId);
        return  user;
    }

    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn", false))
            return true;
        else
            return false;
    }

    public void clearUser(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();

    }

}
