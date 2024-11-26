package com.onlineShop.app.modules

import com.onlineShop.app.api.invoices.InvoiceApi
import com.onlineShop.app.api.invoices.TransactionApi
import com.onlineShop.app.api.products.ColorApi
import com.onlineShop.app.api.products.ProductApi
import com.onlineShop.app.api.products.ProductCategoryApi
import com.onlineShop.app.api.site.BlogApi
import com.onlineShop.app.api.site.ContentApi
import com.onlineShop.app.api.site.SliderApi
import com.onlineShop.app.repositories.customer.UserRepository
import com.onlineShop.app.repositories.invoices.InvoiceRepository
import com.onlineShop.app.repositories.invoices.TransactionRepository
import com.onlineShop.app.repositories.products.ColorRepository
import com.onlineShop.app.repositories.products.ProductCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.onlineShop.app.api.customers.UserApi
import com.onlineShop.app.repositories.products.ProductRepository
import com.onlineShop.app.repositories.site.BlogRepository
import com.onlineShop.app.repositories.site.ContentRepository
import com.onlineShop.app.repositories.site.SliderRepository
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