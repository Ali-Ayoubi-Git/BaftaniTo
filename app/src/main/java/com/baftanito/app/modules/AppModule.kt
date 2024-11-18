package com.baftanito.app.modules

import com.baftanito.app.api.invoices.InvoiceApi
import com.baftanito.app.api.invoices.TransactionApi
import com.baftanito.app.api.products.ColorApi
import com.baftanito.app.api.products.ProductApi
import com.baftanito.app.api.products.ProductCategoryApi
import com.baftanito.app.api.site.BlogApi
import com.baftanito.app.api.site.ContentApi
import com.baftanito.app.api.site.SliderApi
import com.baftanito.app.repositories.customer.UserRepository
import com.baftanito.app.repositories.invoices.InvoiceRepository
import com.baftanito.app.repositories.invoices.TransactionRepository
import com.baftanito.app.repositories.products.ColorRepository
import com.baftanito.app.repositories.products.ProductCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.baftanito.app.api.customers.UserApi
import com.baftanito.app.repositories.products.ProductRepository
import com.baftanito.app.repositories.site.BlogRepository
import com.baftanito.app.repositories.site.ContentRepository
import com.baftanito.app.repositories.site.SliderRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideUserRepository(api: UserApi) = UserRepository(api)

    @Provides
    @Singleton
    fun provideInvoiceRepository(api: InvoiceApi) = InvoiceRepository(api)

    @Provides
    @Singleton
    fun provideTransactionRepository(api: TransactionApi) = TransactionRepository(api)

    @Provides
    @Singleton
    fun provideColorRepository(api: ColorApi) = ColorRepository(api)

    @Provides
    @Singleton
    fun provideProductCategoryRepository(api: ProductCategoryApi) = ProductCategoryRepository(api)

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi) = ProductRepository(api)

    @Provides
    @Singleton
    fun provideSliderRepository(api: SliderApi) = SliderRepository(api)

    @Provides
    @Singleton
    fun provideBlogRepository(api: BlogApi) = BlogRepository(api)

    @Provides
    @Singleton
    fun provideContentRepository(api: ContentApi) = ContentRepository(api)

}