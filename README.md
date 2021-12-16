RA - mapping

## Deploy
kubectl delete namespace epof-backend-int1
kubectl create namespace epof-backend-int1

kubectl -n epof-backend-int1 delete -f ./epof-backend-delivery-processor.yml
kubectl -n epof-backend-int1 apply -f ./epof-backend-delivery-processor.yml

kubectl -n epof-backend-int1 get pods
kubectl -n epof-backend-int1 logs -f epof-backend-delivery-processor-0

kubectl -n epof-backend-int1 exec --stdin --tty epof-backend-delivery-processor-0 -- /bin/bash
kubectl -n epof-backend-int1 describe pod epof-backend-delivery-processor-0
kubectl -n epof-backend-int1 get -o yaml pod epof-backend-delivery-processor-0

kubectl -n epof-backend-int1 scale --replicas=3 StatefulSet/epof-backend-delivery-processor

## Access
http://localhost/30080