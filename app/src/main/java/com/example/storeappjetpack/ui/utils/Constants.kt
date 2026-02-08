package com.example.storeappjetpack.ui.utils


object Constants {

    var CustomDarkThem = false

    const val ENGLISH_LANG = "en"
    const val PERSIAN_LANG = "fa"
    const val DATASTORE_NAME = "my_digikala_data_store"
    const val BASE_URL = "https://truelearn-digikala.iran.liara.run/api/"
    const val PURCHASE_URL = "https://api.zarinpal.com/pg/v4/payment/"
    const val ZARINPAL_PAYMENT_URL = "https://www.zarinpal.com/pg/StartPay/"
    const val TIMEOUT_IN_SECOND: Long = 60
   /* const val API_KEY = BuildConfig.X_API_KEY

    const val KEY = BuildConfig.KEY
    const val IV = BuildConfig.IV*/
    const val ZARINPAL_MERCHANT_ID = "ce7101df-cb08-41f8-a20b-b21995173d8f"
    const val SHOPPING_CART_TABLE = "shopping_cart_table"
    const val DATABASE_NAME = "digikala_db"
    const val FAVE_DAO_TABLE = "fave_dao_table"
    var USER_LANGUAGE = "user_language"
    var USER_TOKEN = "USER_TOKEN"
    var USER_ID = "USER_ID"
    var USER_PHONE = "USER_PHONE"
    var USER_PASSWORD = "USER_PASSWORD "
    var USER_NAME = "کاربر مهمان "

    const val PRODUCT_COMMENT = "PRODUCT_COMMENT"
    const val USER_COMMENT = "USER_COMMENT"


    const val DIGIJET_URL = "https://www.digikalajet.com/user/address"
    const val AUCTION_URL =
        "https://www.digistyle.com/sale-landing/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=style&promo_name=style&promo_position=circle_badge"
    const val DIGIPAY_URL = "https://www.mydigipay.com/"
    const val PINDO_URL =
        "https://www.pindo.ir/?utm_source=digikala&utm_medium=circle_badge&utm_campaign=pindo&promo_name=pindo&promo_position=circle_badge"
    const val SHOPPING_URL =
        "https://www.digikala.com/landings/village-businesses/?promo_name=boomi-landing&promo_position=circle_badge"
    const val GIFT_CARD_URL =
        "https://www.digikala.com/landing/gift-card-landing/?promo_name=gift_landing&promo_position=circle_badge"
    const val DIGIPLUS_URL = "https://www.digikala.com/plus/landing/"
    const val MORE_URL = "https://www.digikala.com/mehr/"


    const val DIGI_FAQ = "https://www.digikala.com/faq/"
    const val DIGI_PRIVACY = "https://www.digikala.com/page/privacy/"
    const val DIGI_TERMS = "https://www.digikala.com/page/terms/"
    const val DIGI_TURLEARN = "https://truelearn.ir/"
    const val DIGI_BUG = "https://www.digikala.com/page/bug-report/"
    const val DIGI_SCORE = "https://cafebazaar.ir/app/com.digikala"

    const val DIGI_WALLET = "https://www.mydigipay.com/"
    const val DIGI_CLUB = "https://www.digikala.com/digiclub/"
    const val TURLEARN_CONTACT_US = "https://truelearn.ir/contact/"

    var isFromPurchase = false
    var afterPurchaseUrl =""
    var purchaseOrderId =""
    var purchasePrice =""

}