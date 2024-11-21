package com.baftanito.app.models.products

data class Product(
    var id : Long,
    var addDate: String?,
    var category: ProductCategory?,
    var colors: List<ProductColor>,
    var description: String,
    var image: String?,
    var price: Long?,
    var sizes: List<ProductSize>?,
    var title: String?,
    var visitCount: Int?



)
