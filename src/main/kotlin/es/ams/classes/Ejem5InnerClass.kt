package es.ams.classesinner

class BusinessEntity(
        val id: Int,
        val name: String,
        val address: String,
        val flag: Int
){
    val repository: BusinessEntityDAO

    init{
        repository = BusinessEntityDAO()
    }

    fun doBusinessOperation1(): Int {
        return (flag * id)  + repository.loadValurFromSystem()
    }

    fun doBusinessOperation2(): String {
        return id.toString() + name + doBusinessOperation1().toString()
    }

    fun loadMySelg(): BusinessEntity {
        return repository.getBusinessEntity()
    }

    override fun toString(): String {
        return "BusinessEntity(id=$id, name='$name', address='$address', flag=$flag, repository=$repository)"
    }

    // Inner class ---------------------------------
    inner class BusinessEntityDAO{
        fun loadValurFromSystem(): Int {
            return 20
        }

        fun getBusinessEntity(): BusinessEntity {
            return this@BusinessEntity
        }

        override fun toString(): String {
            return "BusinessEntityDAO()"
        }
    }
}


fun main() {
    val entity = BusinessEntity(1, "name1", "address1", 10)
    println("OperationBusiness1=${entity.doBusinessOperation1()}")
    println("OperartionBusiness2=${entity.doBusinessOperation2()}")
    println("toString=${entity.loadMySelg().toString()}")
    println()
}
