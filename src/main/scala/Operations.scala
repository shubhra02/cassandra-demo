import com.datastax.driver.core.{Cluster, Session}
import org.apache.log4j.Logger

class Operations {

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()
  val session: Session = cluster.connect("operations")
  val log = Logger.getLogger(classOf[Operations])

  def selectByEmail(email:String) = {

    // session.execute("insert into video(video_name,userid,video_id,year) values('Fast and Furious' ',11,111,2017);")
    val response = session.execute(s"select * from user where email='$email' ")
    val result = response.iterator()

    while (result.hasNext) {
      log.info(result.next())
    }
  }

  def selectByVideoName(videoname:String) = {

    val response = session.execute(s"select * from user from video = '$videoname' ")
    val result = response.iterator()

    while (result.hasNext) {
      log.info(result.next())
    }
  }

  def selectVideoByYear(year:Int) = {
    val response = session.execute(s"select * from user from videoByYear where year > $year allow filtering")
    val result = response.iterator()

    while (result.hasNext) {
      log.info(result.next())
    }

  }

  def selectVideoByIdAndYear(userId:Int) = {

    val response = session.execute(s"select * from videoByYear where userId = $userId ORDER BY year ASC LIMIT 3;")
    val result = response.iterator()

    while (result.hasNext) {
      log.info(result.next())
    }

  }
  cluster.close()
}