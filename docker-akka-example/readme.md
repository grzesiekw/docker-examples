Run:

docker run -v `pwd`/target/scala-2.10:/usr/akka/deploy:rw grzesiekw/akka /usr/akka/bin/akka com.gw.example.HelloKernel