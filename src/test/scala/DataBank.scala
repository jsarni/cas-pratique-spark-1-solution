import org.apache.spark.sql.{DataFrame, SparkSession}

class DataBank(spark: SparkSession) {

  import spark.implicits._

  val servicesCsvDF: DataFrame =
    Seq(
      (1, "Compta"),
      (2, "Achat"),
      (3, "Vente"),
      (4, "RH")
    ).toDF("id", "nom")


  val employesParquetDF: DataFrame =
    Seq(
      (1, 1, 50000.0, false),
      (2, 2, 41000.0, false),
      (3, 3, 39000.0, false),
      (4, 4, 50000.0, true),
      (5, 3, 120000.0, true),
      (6, 3, 10000.0, false),
      (7, 3, 45000.0, false),
      (8, 2, 110000.0, true),
      (9, 3, 27000.0, true),
      (10, 4, 23000.0, false),
      (11, 4, 13000.0, true)
    ).toDF("id", "service_id", "salaire", "masculin")

  val exercice1DF: DataFrame =
    Seq(
      (1, 1, 50000.0, false),
      (2, 2, 41000.0, false),
      (4, 4, 50000.0, true),
      (5, 3, 120000.0, true),
      (7, 3, 45000.0, false),
      (8, 2, 110000.0, true)
    ).toDF("id", "service_id", "salaire", "masculin")

  val exercice2DF: DataFrame =
    Seq(
      (1, "Compta"),
      (2, "Achat"),
      (3, "Vente"),
      (4, "RH"),
      (5, "Vente"),
      (6, "Vente"),
      (7, "Vente"),
      (8, "Achat"),
      (9, "Vente"),
      (10, "RH"),
      (11, "RH")
    ).toDF("employe_id", "service")

}

object DataBank {
  def apply(spark: SparkSession): DataBank = new DataBank(spark)
}
