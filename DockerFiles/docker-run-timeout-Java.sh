#!/bin/bash
set -e

to=$1
testfile=$2
folder=$3
shift


# -d para ejecutar en background
# -v para indicar el volumen que se monta /home/joheras/Escritorio/:/home/data (la parte de antes de :
# es el volumen del ordenador origen y lo que va después el sistema de ficheros del contenedor.
cont=$(docker run -it -d -v "$folder":/home/data junit4 sh -c "java -cp .:junit4.jar:hamcrest-core.jar org.junit.runner.JUnitCore $testfile 1>> /home/data/informe.txt")
code=$(timeout "$to" docker wait "$cont" || true)
docker kill $cont &> /dev/null
echo -n 'status: '
if [ -z "$code" ]; then
    echo timeout 1>> "$folder"/informe.txt
else
    echo exited: $code
fi

echo output:
# pipe to sed simply for pretty nice indentation
docker logs $cont | sed 's/^/\t/'

docker rm $cont &> /dev/null
