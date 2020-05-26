package buildings

open class BaseBuildingMaterial{
    open var numberNeeded = 1
}

class Wood: BaseBuildingMaterial() {
    override var numberNeeded: Int = 4
}

class Brick: BaseBuildingMaterial() {
    override var numberNeeded: Int = 4
}

class Building<T: BaseBuildingMaterial>(val material: T){
    private val baseMaterialsNeeded = 100
    val actualMaterialNeeded = baseMaterialsNeeded * material.numberNeeded

    fun build() {
        println("${material::class.simpleName} needs $actualMaterialNeeded")
    }
}

fun <T: BaseBuildingMaterial>isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialNeeded >= 500) println("large building")
    else println("small building")
}

fun main(){
    val building = Building(Wood())
    building.build()
    isSmallBuilding(building)
}