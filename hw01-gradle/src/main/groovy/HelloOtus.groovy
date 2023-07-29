import com.google.common.collect.Lists

static void main(String[] args) {
    def userList = Lists.newArrayList("Ivan, Petr, Maksim")
    println userList.join(",")
}