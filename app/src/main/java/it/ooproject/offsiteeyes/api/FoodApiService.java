package it.ooproject.offsiteeyes.api;

import it.ooproject.offsiteeyes.utils.Util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FoodApiService {
    private static Retrofit retrofit = null;
    public static <ServiceApi> ServiceApi getApiService(Class<ServiceApi> serviceClass) {
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Util.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return FoodApiService.createService(serviceClass);
    }

    private static <ServiceApi> ServiceApi createService(Class<ServiceApi> serviceClass){
        return retrofit.create(serviceClass);
    }
}