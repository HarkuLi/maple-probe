.PHONY: up
up: frontend/.env
	docker compose up -d

.PHONY: down
down:
	docker compose down

.PHONY: build
build: frontend/.env
	docker compose build

.env: .env.example
	cp $< $@

frontend/.env: .env
	cp $< $@
