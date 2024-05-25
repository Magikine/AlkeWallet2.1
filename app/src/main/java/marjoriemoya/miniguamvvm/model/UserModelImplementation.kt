package marjoriemoya.miniguamvvm.model

class UserModelImplementation : UserModel {

    private var fullName: String = ""

    override fun getFullName(): String {
        return fullName
    }

    override fun setFullName(fullName: String) {
        this.fullName = fullName
    }
}