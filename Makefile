NAME   := 637423212230.dkr.ecr.us-east-2.amazonaws.com/fiktionmaps
TAG    := $$(git log -1 --pretty=%H)
IMG    := ${NAME}:${TAG}
LATEST := ${NAME}:latest
RELEASE:= ${NAME}:release
DEV	   := ${NAME}:dev

.PHONY: build clean

build:
	@gradlew clean build --warning-mode all -x test

deploy:
	@docker build -t ${IMG} .
	@docker tag ${IMG} ${LATEST}
	@docker tag ${IMG} ${DEV}
	@docker push ${DEV}
	@docker push ${LATEST}
	@docker push ${IMG}
	@aws ecs --region us-east-2 --profile fpossetto update-service --cluster dev-ar-cluster --service prod-backend-service --force-new-deployment

login:
	@aws ecr get-login-password --region us-east-2 --profile fpossetto | docker login --username AWS --password-stdin 637423212230.dkr.ecr.us-east-2.amazonaws.com