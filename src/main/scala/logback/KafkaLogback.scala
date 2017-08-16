/*Simple word count example
* The kafka stream works as source to flink.
* Flink creates windowed stream
* Logback is configured with elasticsearch appender.
*/
package com.autolitix.flink
import org.apache.flink.streaming.api.scala._
import java.util.Properties
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer010
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010
import org.apache.flink.streaming.util.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.windowing.time.Time
import com.typesafe.scalalogging.LazyLogging
//
class KafkaLogback(logbackAppender: ElasticSearchLogbackAppender){
  def run(): Unit = {
    logbackAppender.connect()
  }
}
object KafkaLogback extends SLogger{
  
  def main(args: Array[String]) : Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    val prop = new Properties()
    prop.setProperty("bootstrap.servers", "localhost:9092");
    prop.setProperty("zookeeper.connect", "localhost:2181");
    prop.setProperty("group.id", "some");
    info("Creating data stream from kafka topic as source")
    val dataStreamSource = env.
      addSource(new FlinkKafkaConsumer010[String]("test", new SimpleStringSchema(), prop))
    val keyStream = dataStreamSource.flatMap(line => line.split(" "))
      .map(w => (w,1))
      .keyBy(0)
      .timeWindow(Time.seconds(20))
      .sum(1)
    keyStream.map(_.toString).addSink(
      new FlinkKafkaProducer010[String](
        "localhost:9092",
        "output", 
        new SimpleStringSchema()
      )
    )
    env.execute("KafkaStreamCosumer")
  }

}