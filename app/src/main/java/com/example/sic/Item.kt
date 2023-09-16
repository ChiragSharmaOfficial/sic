import android.os.Parcelable
import kotlinx.parcelize.Parcelize
//@Parcelize: This annotation is applied to the Item data class. It tells the Kotlin compiler to generate the necessary code for making the Item class Parcelable.

@Parcelize//import android.os.Parcelable: This line imports the Parcelable interface from the Android operating system's android.os package. Parcelable is used for efficiently passing data between different components of an Android app, such as between activities and fragments.
//import kotlinx.parcelize.Parcelize: This line imports the Parcelize annotation from the kotlinx.parcelize package. The Parcelize annotation is used to automatically generate code for making the class Parcelable, which means it can be easily passed between different parts of an Android app.

data class Item(//data class Item(...): This is the definition of the Item data class. It represents an item with several properties, including:

    val name: String,
    val rating: Double,
    val attribute: String,
    val pricePerDay: Double,
    val imageResourceId: Int,
    val reservationData: String
) : Parcelable
//name: A string representing the name of the item.
//rating: A double representing the rating of the item.
//attribute: A string representing some attribute of the item.
//pricePerDay: A double representing the price of the item per day.
//imageResourceId: An integer representing the resource ID of the item's image.
//reservationData: A string representing data related to the item's reservation.
//: Parcelable: This indicates that the Item class implements the Parcelable interface. By doing this, the class promises to provide methods for reading from and writing to a Parcel (a special Android class used for efficient data serialization), which is necessary for passing instances of this class between components of an Android app.