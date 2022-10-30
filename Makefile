.DEFAULT_GOAL := build-run

build:
	make -C app clean build

lint:
	make -C app lint

report:
	make -C app report

.PHONY: build