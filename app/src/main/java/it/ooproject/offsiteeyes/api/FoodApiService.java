package it.ooproject.offsiteeyes.api;

import it.ooproject.offsiteeyes.utils.Util;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * FoodApiService is a singleton pattern class. This means that in the complete
 * application there will be only one object of the FoodApiService class. This
 * fact allows to create a unique and secure way to access to the FoodApi REST
 * service with retrofit library
 */
public class FoodApiService {
    private static Retrofit retrofit = null;

    /**
     *
     * @param serviceClass service public interface containing the endpoints
     * @param <ServiceApi>
     * @return
     */
    public static <ServiceApi> ServiceApi getApiService(Class<ServiceApi> serviceClass) {
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Util.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(serviceClass);
    }
}