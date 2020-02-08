#FROM oracle/graalvm-ce:19.3.1-java8 as graalvm
FROM oracle/graalvm-ce:19.3.1-java11 as graalvm
RUN gu install native-image

COPY . /home/app/complete
WORKDIR /home/app/complete

RUN native-image --no-server --static -cp build/libs/complete-*-all.jar

FROM scratch
EXPOSE 8080
COPY --from=graalvm /home/app/complete/complete /app/complete
ENTRYPOINT ["/app/complete", "-Djava.library.path=/app"]
