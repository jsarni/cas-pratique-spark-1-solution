import org.apache.spark.sql.DataFrame
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.{GivenWhenThen, OptionValues, TryValues}

class CasPratiqueSpark1Test extends AnyFlatSpec
  with GivenWhenThen
  with Matchers
  with OptionValues
  with TryValues  {

  import CasPratiqueSpark1._

  val dataBank = DataBank(spark)

  "loadEmployesParquet" should "pass" in {
    val result: DataFrame = loadEmployesParquet()

    result.collect() should contain theSameElementsInOrderAs dataBank.employesParquetDF.collect()
  }

  "loadServicesCsv" should "pass" in {
    val result: DataFrame = loadServicesCsv()

    result.collect() should contain theSameElementsInOrderAs dataBank.servicesCsvDF.collect()
    result.columns should contain theSameElementsAs dataBank.servicesCsvDF.columns
  }

  "exercice1" should "pass" in {
    val result: DataFrame = exercice1()

    result.collect() should contain theSameElementsInOrderAs dataBank.exercice1DF.collect()
  }

  "exercice2" should "pass" in {
    val result: DataFrame = exercice2()

    result.collect() should contain theSameElementsInOrderAs dataBank.exercice2DF.collect()
    result.columns should contain theSameElementsAs dataBank.exercice2DF.columns
  }

}
