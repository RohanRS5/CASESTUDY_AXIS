import java.sql.DriverManager

// MODEL CLASS......

data class User(val id: Int ,val ticket_number: Int, val  passenger_ID: Int, val  train_ID : Int, val ticket_Price : Int )

fun main(args: Array<String>) {
    val jdbcUrl = "jdbc:mysql://localhost:3306/casestudy1"
    val connection = DriverManager.getConnection(jdbcUrl, "root", "Rockdale@27")
    println(connection.isValid(0))

    // INSERT QUERY.....

    val res = connection.createStatement().executeUpdate("insert into ticket( id , ticket_number , passenger_ID , train_ID , ticket_Price) values (3,34453,1,1,1700)")
    if (res>0){
        println("Successfully records into users db !!!")
    }
    else {
        println("not successful")
    }

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

    val query = connection.prepareStatement("select * from ticket")
    val result = query.executeQuery()
    val users = mutableListOf<User>()

    while (result.next()) {
        val id = result.getInt("id")
        val ticket_number = result.getInt("ticket_number")
        val  passenger_ID = result.getInt("passenger_ID")
        val train_ID = result.getInt("train_ID")
        val  ticket_Price = result.getInt("ticket_Price")


        users.add(User(id, ticket_number, passenger_ID, train_ID, ticket_Price))
    }

    println(users)
}