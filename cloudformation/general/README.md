aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-roles --template-body file://./general/1_roles.yml --capabilities CAPABILITY_NAMED_IAM

aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-vpc --template-body file://./general/2_vpc.yml

aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-cluster --template-body file://./general/3_cluster.yml

aws --profile franv2 --region us-east-2 cloudformation create-stack --stack-name prod-mesh --template-body file://./general/4_mesh.yml
