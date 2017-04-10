
object Application extends App{

  val operationsObj = new Operations
  operationsObj.selectByEmail("shubhra.sharma@gmail.com")
  operationsObj.selectByVideoName("Sarkar")
  operationsObj.selectVideoByYear(2017)
  operationsObj.selectVideoByIdAndYear(112)

}