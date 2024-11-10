package com.baftanito.modules

import com.baftanito.api.invoices.InvoiceApi
import com.baftanito.api.invoices.TransactionApi
import com.baftanito.api.products.ColorApi
import com.baftanito.api.products.ProductApi
import com.baftanito.api.products.ProductCategoryApi
import com.baftanito.api.site.BlogApi
import com.baftanito.api.site.ContentApi
import com.baftanito.api.site.SliderApi
import com.baftanito.repositories.customer.UserRepository
import com.baftanito.repositories.invoices.InvoiceRepository
import com.baftanito.repositories.invoices.TransactionRepository
import com.baftanito.repositories.products.ColorRepository
import com.baftanito.repositories.products.ProductCategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.holosen.onlineshopapp.api.customer.UserApi
import com.baftanito.repositories.products.ProductRepository
import com.baftanito.repositories.site.BlogRepository
import com.baftanito.repositories.site.ContentRepository
import com.baftanito.repositories.site.SliderRepository
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