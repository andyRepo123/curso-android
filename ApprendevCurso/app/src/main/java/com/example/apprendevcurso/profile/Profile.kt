package com.example.apprendevcurso.profile

import android.os.Parcel
import android.os.Parcelable

data class Profile(
    val profileId: String?,
    val userName: String?,
    val name: String?,
    val lastName: String?,
    val userDescription: String?
) : Parcelable {
    constructor(parcelProfile: Parcel) : this(
        parcelProfile.readString(),
        parcelProfile.readString(),
        parcelProfile.readString(),
        parcelProfile.readString(),
        parcelProfile.readString()
    )

    override fun writeToParcel(parcelProfile: Parcel, flags: Int) {
        parcelProfile.writeString(profileId)
        parcelProfile.writeString(userName)
        parcelProfile.writeString(name)
        parcelProfile.writeString(lastName)
        parcelProfile.writeString(userDescription)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Profile> {
        override fun createFromParcel(parcelProfile: Parcel) = Profile(parcelProfile)

        override fun newArray(size: Int): Array<Profile?> = arrayOfNulls(size)
    }
}
