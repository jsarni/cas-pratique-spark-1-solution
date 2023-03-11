import org.apache.spark
import org.apache.spark.sql.{DataFrame, SparkSession}

object CasPratiqueSpark1 {

  val spark: SparkSession = SparkSession
    .builder()
    .master("local[1]")
    .appName("CasPratiqueSpark")
    .getOrCreate()

  import spark.implicits._

  /**
   * Implémenter cette méthode pour lire le parquet contenant la liste des employés
   */
  def loadEmployesParquet(): DataFrame = {
    spark
      .read
      .parquet(getClass.getResource("Employes").getPath)
  }


  /**
   * Implémenter cette méthode pour lire le CSV contenant la liste des services
   * Attention, lors de la lecture d'un csv, il faut parfois définir quelques options de lecture
   */
  def loadServicesCsv(): DataFrame = {
    spark
      .read
      .options(Map("inferSchema" -> "true", "header" -> "true"))
      .csv(getClass.getResource("Services").getPath)
  }


  /**
   * Récupérer les employés touchant plus de 40 000 euros
   */
  def exercice1(): DataFrame = {
    val employes: DataFrame = loadEmployesParquet()

    employes.filter($"salaire" >= 40000)
  }


  /**
   * Associer pour chaque employé, récupérer le nom de son service
   *
   * Résultat Attendu:
   *
   * ------------------------
   * | employe_id | service |
   * ------------------------
   * |            |         |
   * ------------------------
   *
   * Tip: On peut donner un alias à une DF ou à une colonne, afin de faciliter le traitement
   */
  def exercice2(): DataFrame = {
    val employes: DataFrame = loadEmployesParquet()
    val services: DataFrame = loadServicesCsv()

    employes
      .as("e")
      .join(services.as("s"), $"e.service_id" === $"s.id")
      .select(
        $"e.id".as("employe_id"),
        $"s.nom".as("service")
      )
  }

}
