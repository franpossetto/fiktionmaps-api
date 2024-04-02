aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-backend-roles --template-body file://./backend/1_backend_roles.yml --capabilities CAPABILITY_NAMED_IAM

aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-backend-mesh --template-body file://./backend/2_backend_mesh.yml

aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-backend-service --template-body file://./backend/3_backend_service.yml
