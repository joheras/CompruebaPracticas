#include <iostream>
#define CATCH_CONFIG_MAIN
#include "catch.hpp"
#include "FSObject.h"
#include "Directory.h"
#include "TextFile.h"
#include "FileManager.h"

using namespace std;






TEST_CASE("FSObject Constructor and Getters", "[FSObject-constructor]" ) {

        FSObject *fso = new FSObject("test");
		REQUIRE("test"==fso->getName());
		REQUIRE(0==fso->getInode());
		bool equalpermissions =true;
		char*  permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);

		FSObject * fso1 = new FSObject("test1");
		REQUIRE("test1"==fso1->getName());
		REQUIRE(1==fso1->getInode());
		equalpermissions =true;
		permissions=fso1->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);
}


TEST_CASE("SetName", "[FSObject-setName]" ) {

        FSObject * fso = new FSObject("test");
		fso->setName("test2");
		int iNode = fso->getInode();
		char* permissions = fso->getPermissions();
		REQUIRE("test2"==fso->getName());
		REQUIRE(iNode== fso->getInode());
		bool equalpermissions =true;
		permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);
}

TEST_CASE("SetPermissions", "[FSObject-setPermissions]" ) {

        FSObject * fso = new FSObject("test");
		string name = fso->getName();
		int iNode = fso->getInode();
		char perm[10];
		for(int i=0;i<3;i++){
        perm[3*i]='w';
        perm[3*i+1]='-';
        perm[3*i+2]='r';
    }
    fso->setPermissions(perm);


		char* permissions = fso->getPermissions();
		REQUIRE(name==fso->getName());
		REQUIRE(iNode== fso->getInode());
		bool equalpermissions =true;
		permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='-');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='r');
		}
        REQUIRE(equalpermissions==true);
}





TEST_CASE("TextFile Constructor and Getters", "[TextFile-constructor]" ) {

        TextFile *fso = new TextFile("test","Fichero de texto");
		REQUIRE("test"==fso->getName());
		REQUIRE(4==fso->getInode());
		bool equalpermissions =true;
		char*  permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);
        REQUIRE("Fichero de texto"==fso->getContent());

}


TEST_CASE("SetContent", "[FSObject-setContent]" ) {

        TextFile *fso = new TextFile("test","Fichero de texto");
		string name = fso->getName();
		int iNode = fso->getInode();
		char* permissions = fso->getPermissions();
		fso->setContent("test2");

		REQUIRE(name==fso->getName());
		REQUIRE(iNode== fso->getInode());
		bool equalpermissions =true;
		permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);
        REQUIRE("test2"==fso->getContent());
}



TEST_CASE("Directory Constructor and Getters", "[Directtory-constructor]" ) {

        Directory *fso = new Directory("test");
		REQUIRE("test"==fso->getName());
		REQUIRE(6==fso->getInode());
		bool equalpermissions =true;
		char*  permissions=fso->getPermissions();
		for(int i=0;i<3;i++){
            equalpermissions=equalpermissions&&(permissions[3*i]=='r');
            equalpermissions=equalpermissions&&(permissions[3*i+1]=='w');
            equalpermissions=equalpermissions&&(permissions[3*i+2]=='-');
		}
        REQUIRE(equalpermissions==true);
}

TEST_CASE("Directory AddFile SearchFile", "[testAddFilesSearchFile]" ) {

        Directory * dir = new Directory("test");
		TextFile * tf1 = new TextFile("file1", "");
		REQUIRE(true==dir->addFile(tf1));
		REQUIRE(NULL!=dir->searchFile(tf1->getName()));

		TextFile * tf2 = new TextFile("file2", "");
		REQUIRE(true==dir->addFile(tf2));
		REQUIRE(NULL!=dir->searchFile(tf2->getName()));

		TextFile * tf3 = new TextFile("file3", "");
		REQUIRE(true==dir->addFile(tf3));
		REQUIRE(NULL!=dir->searchFile(tf3->getName()));

		TextFile *tf4 = new TextFile("file4", "");
		REQUIRE(true==dir->addFile(tf4));
		REQUIRE(NULL!= dir->searchFile(tf4->getName()));

		REQUIRE( false==dir->addFile(tf1));
		REQUIRE( false==dir->addFile(tf2));
		REQUIRE(false==dir->addFile(tf3));
		REQUIRE(false==dir->addFile(tf4));

}


TEST_CASE("Directory DeleteFile SearchFile", "[testDeleteFileSearchFile]" ) {

       Directory *dir = new Directory("test");
		TextFile* tf1 = new TextFile("file1", "");
		dir->addFile(tf1);
		TextFile *tf2 = new TextFile("file2", "");
		dir->addFile(tf2);
		TextFile *tf3 = new TextFile("file3", "");
		dir->addFile(tf3);
		TextFile *tf4 = new TextFile("file4", "");
		dir->addFile(tf4);
		TextFile *tf5 = new TextFile("file5", "");
		dir->addFile(tf5);



		REQUIRE(true==dir->removeFile(tf3->getName()) );
		REQUIRE(NULL==dir->searchFile(tf3->getName()));
		REQUIRE(true==dir->removeFile(tf5->getName()) );
		REQUIRE(NULL== dir->searchFile(tf5->getName()));
		REQUIRE(true==dir->removeFile(tf1->getName()) );
		REQUIRE(NULL== dir->searchFile(tf1->getName()));
		REQUIRE( true==dir->removeFile(tf2->getName()) );
		REQUIRE(NULL==dir->searchFile(tf2->getName()));
		REQUIRE(true==dir->removeFile(tf4->getName()) );
		REQUIRE(NULL==dir->searchFile(tf4->getName()));

		REQUIRE(false==dir->removeFile(tf4->getName()) );

}



TEST_CASE("FileManager AddDirectory SearchDirectory", "[testAddDirectoriesSearchDirectories]" ) {


		Directory * tf1 = new Directory("dir1");
		REQUIRE(true==FileManager::addDirectory(tf1));
		REQUIRE(NULL!=FileManager::searchDirectory(tf1->getName()));

		Directory * tf2 = new Directory("dir2");
		REQUIRE(true==FileManager::addDirectory(tf2));
		REQUIRE(NULL!=FileManager::searchDirectory(tf2->getName()));

		Directory * tf3 = new Directory("dir3");
		REQUIRE(true==FileManager::addDirectory(tf3));
		REQUIRE(NULL!=FileManager::searchDirectory(tf3->getName()));

		Directory *tf4 = new Directory("dir4");
		REQUIRE(true==FileManager::addDirectory(tf4));
		REQUIRE(NULL!= FileManager::searchDirectory(tf4->getName()));

		REQUIRE( false==FileManager::addDirectory(tf1));
		REQUIRE( false==FileManager::addDirectory(tf2));
		REQUIRE(false==FileManager::addDirectory(tf3));
		REQUIRE(false==FileManager::addDirectory(tf4));

}


TEST_CASE("FileManager DeleteDirectory SearchDirectory", "[testDeleteDirectorySearchDirectory]" ) {

       Directory *dir = new Directory("test");
		Directory* tf1 = new Directory("file1");
		FileManager::addDirectory(tf1);
		Directory *tf2 = new Directory("file2");
		FileManager::addDirectory(tf2);
		Directory *tf3 = new Directory("file3");
		FileManager::addDirectory(tf3);
		Directory *tf4 = new Directory("file4");
		FileManager::addDirectory(tf4);
		Directory *tf5 = new Directory("file5");
		FileManager::addDirectory(tf5);



		REQUIRE(true==FileManager::removeDirectory(tf3->getName()) );
		REQUIRE(NULL==FileManager::searchDirectory(tf3->getName()));
		REQUIRE(true==FileManager::removeDirectory(tf5->getName()) );
		REQUIRE(NULL== FileManager::searchDirectory(tf5->getName()));
		REQUIRE(true==FileManager::removeDirectory(tf1->getName()) );
		REQUIRE(NULL== FileManager::searchDirectory(tf1->getName()));
		REQUIRE( true==FileManager::removeDirectory(tf2->getName()) );
		REQUIRE(NULL==FileManager::searchDirectory(tf2->getName()));
		REQUIRE(true==FileManager::removeDirectory(tf4->getName()) );
		REQUIRE(NULL==FileManager::searchDirectory(tf4->getName()));

		REQUIRE(false==FileManager::removeDirectory(tf4->getName()) );

}



