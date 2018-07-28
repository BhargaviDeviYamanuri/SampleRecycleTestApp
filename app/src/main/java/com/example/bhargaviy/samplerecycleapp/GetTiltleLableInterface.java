package com.example.bhargaviy.samplerecycleapp;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Bhargavi Y on 7/28/2018.
 */

public class GetTiltleLableInterface {
    public static lableList lableListListener;

    public static void titleLables() {
        final ArrayList<String> lableLs = new ArrayList<>();
        JsonObjectRequest lableReq = new JsonObjectRequest(Request.Method.GET, Constant.GET_LABLE_URL, new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response.has(Constant.FEED)) {
                    try {
                        JSONObject feedObj = response.getJSONObject(Constant.FEED);
                        JSONArray entryArry = feedObj.getJSONArray(Constant.ENTRY);
                        for (int i = 0; i < entryArry.length(); i++) {
                            JSONObject object = entryArry.getJSONObject(i);
                            if (object.has(Constant.TITLE)) {
                                JSONObject titleObj = object.getJSONObject(Constant.TITLE);
                                if (titleObj.has(Constant.LABLE)) {
                                    lableLs.add(titleObj.getString(Constant.LABLE));
                                }
                            }
                        }
                        if (lableListListener!=null){
                            lableListListener.listOfLables(Constant.SUCCESS,lableLs);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        if (lableListListener!=null){
                            lableListListener.listOfLables(Constant.FAIL,lableLs);
                        }
                    }
                }else {
                    if (lableListListener!=null){
                        lableListListener.listOfLables(Constant.FAIL,lableLs);
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if (lableListListener!=null){
                    lableListListener.listOfLables(Constant.FAIL,lableLs);
                }
            }
        });
        AppControler.getInstance().addToRequestQueue(lableReq);
    }

    public interface lableList {
        void listOfLables(String result, ArrayList<String> lables);
    }
}
