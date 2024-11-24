package com.onlineShop.app.modules

import com.onlineShop.app.api.customers.UserApi
import com.onlineShop.app.api.invoices.InvoiceApi
import com.onlineShop.app.api.invoices.TransactionApi
import com.onlineShop.app.api.products.ProductApi
import com.onlineShop.app.api.products.ColorApi
import com.baftanito.app.api.products.ProductCategoryApi
import com.onlineShop.app.api.site.BlogApi
import com.onlineShop.app.api.site.ContentApi
import com.onlineShop.app.api.site.SliderApi
import com.onlineShop.app.config.UnsafeSSLConfig
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import dagger.Module
import dagger.Provides

@Module

@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApi(): Retrofit {
        return Retrofit.Builder()
            //https://192.168.1.10:8080/
            //https://onlineshop.holosen.net
            .baseUrl("https://onlineshop.holosen.net")
            .client(UnsafeSSLConfig.unsafeOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideUserApi(): UserApi {
        return provideApi().create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun provideInvoiceApi(): InvoiceApi {
        return provideApi().create(InvoiceApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTransactionApi(): TransactionApi {
        return provideApi().create(TransactionApi::class.java)
    }

    @Provides
    @Singleton
    fun provideColorApi(): ColorApi {
        return provideApi().create(ColorApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductApi(): ProductApi {
        return provideApi().create(ProductApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductCategoryApi(): ProductCategoryApi {
        return provideApi().create(ProductCategoryApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBlogApi(): BlogApi {
        return provideApi().create(BlogApi::class.java)
    }

    @Provides
    @Singleton
    fun provideContentApi(): ContentApi {
        return provideApi().create(ContentApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSliderApi(): SliderApi {
        return provideApi().create(SliderApi::class.java)
    }
}