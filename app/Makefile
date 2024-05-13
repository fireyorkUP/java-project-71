# запустить исполняемый файл app с опцией -h
help:
	./build/install/app/bin/app -h

# запустить исполняемый файл app с опцией -V
version:
	./build/install/app/bin/app -V

# запустить исполняемый файл app с двумя параметрами
run-dist:
	./build/install/app/bin/app src/test/resources/Json1.json src/test/resources/Json2.json

test:
	./gradlew test

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain

.PHONY: buildbuild/install/app/bin/app