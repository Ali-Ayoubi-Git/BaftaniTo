package com.baftanito.app.modules

import com.baftanito.app.api.customers.UserApi
import com.baftanito.app.api.invoices.InvoiceApi
import com.baftanito.app.api.invoices.TransactionApi
import com.baftanito.app.api.products.ProductApi
import com.baftanito.app.api.products.ColorApi
import com.baftanito.app.api.products.ProductCategoryApi
import com.baftanito.app.api.site.BlogApi
import com.baftanito.app.api.site.ContentApi
import com.baftanito.app.api.site.SliderApi
import com.baftanito.app.config.UnsafeSSLConfig
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
            .baseUrl("https://10.0.2.2:8080/")
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