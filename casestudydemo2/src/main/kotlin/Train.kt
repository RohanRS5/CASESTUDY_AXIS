import java.sql.DriverManager

// MODEL CLASS......

data class User(val train_id: Int ,val train_No: Int, val train_name: String, val source : String, val destination : String, val start_date_time : String, val arrival_time : String )

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/casestudy1"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Rockdale@27")
    println(connection.isValid(0))

    // INSERT QUERY.....

//    val res = connection.createStatement().executeUpdate("insert into train(train_id , train_No, train_name ,source, destination, start_date_time, arrival_time) values (3,765055,'rajdhani','mumbai','delhi','22-12-2022 6:00 am', '23-12-2022 11:00 am')")
//    if (res>0){
//        println("Successfully records into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // UPDATE QUERY......

//    val update = connection.createStatement().executeUpdate("update train set train_name='delhi superfast' where train_id=3")
//    if (update>0){
//        println("Successfully Updated into users db !!!")
//    }
//    else {
//        println("not successful")
//    }

    // DELETE QUERY......

//    val delete = connection.createStatement().executeUpdate("delete from train where train_id=3")
//    if (delete > 0) {
//        println("Successfully Deleted from users db !!!")
//    } else {
//        println("not successful")
//    }

    //SELECT QUERY-READ.......

    val query = connection.prepareStatement("select * from train")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val train_id = result.getInt("train_id")
        val train_No = result.getInt("train_No")
        val train_name = result.getString("train_name")
        val source = result.getString("source")
        val destination = result.getString("destination")
        val start_date_time = result.getString("start_date_time")
        val arrival_time = result.getString("arrival_time")

        users.add(User(train_id,train_No,train_name,source,destination,start_date_time,arrival_time))
    }

    println(users)
}