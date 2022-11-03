.DEFAULT_GOAL := build-run

lint:
	make -C app lint

report:
	make -C app report

.PHONY: build