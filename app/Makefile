.DEFAULT_GOAL := build-run

build:
	./gradlew clean build

lint:
	./gradlew checkstyleMain checkstyleTest

report:
	./gradlew jacocoTestReport

build-run: build run

.PHONY: build