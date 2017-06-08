/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 * @modified jasison
 */
public class ExampleDaoGenerator {

	public static void main(String[] args) throws Exception {
		Schema schema = new Schema(10, "ww.greendao.dao");
		addNote(schema);
		new DaoGenerator().generateAll(schema, "../MyApp3/src-gen");
	}

	private static void addNote(Schema schema) {
		Entity item = schema.addEntity("Item");// Item:生成的实体类类名
		item.addLongProperty("ItemID").primaryKey().autoincrement();
		item.addStringProperty("ItemCode").unique();
		item.addStringProperty("ItemName").unique();
		item.addIntProperty("MinValue");
		item.addIntProperty("MaxValue");
		item.addStringProperty("Unit");
		item.addIntProperty("DataLen");
		item.addIntProperty("CarryMode");
		item.addIntProperty("ItemType");
		item.addStringProperty("MachineCode");
		item.addIntProperty("IsEnable");
		item.addStringProperty("Remark1");

		Entity school = schema.addEntity("School");// School:生成的实体类类名
		school.addLongProperty("SchoolID").primaryKey().autoincrement();
		school.addStringProperty("SchoolName").notNull().unique();
		school.addStringProperty("SchoolYear");
		school.addStringProperty("Remark1");

		Entity grade = schema.addEntity("Grade");// Grade:生成的实体类类名
		grade.addLongProperty("GradeID").primaryKey().autoincrement();
		Property gradeProperty = grade.addLongProperty("SchoolID").getProperty();
		// grade.addStringProperty("SchoolName");
		grade.addStringProperty("GradeCode").unique();
		grade.addStringProperty("GradeName").unique();
		grade.addStringProperty("Remark1");
		// 学校和年级之间建立一对多关系
		grade.addToOne(school, gradeProperty);
		school.addToMany(grade, gradeProperty).setName("grades");

		Entity classes = schema.addEntity("Classes");// Classes:生成的实体类类名
		classes.addLongProperty("ClassID").primaryKey().autoincrement();
		Property classesProperty = classes.addLongProperty("GradeID").notNull().getProperty();
		// classes.addStringProperty("GradeCode");
		classes.addStringProperty("ClassCode").unique();
		classes.addStringProperty("ClassName");
		classes.addStringProperty("Remark1");
		// 年级和班级之间建立一对多关系
		classes.addToOne(grade, classesProperty);
		grade.addToMany(classes, classesProperty).setName("allClass");

		Entity student = schema.addEntity("Student");// Student:生成的实体类类名
		student.addLongProperty("StudentID").primaryKey().autoincrement();
		student.addStringProperty("StudentCode").unique();
		student.addStringProperty("StudentName");
		student.addIntProperty("Sex");
		// student.addStringProperty("ClassCode");
		student.addLongProperty("ClassID");
		student.addLongProperty("GradeID");
		// student.addStringProperty("GradeCode");
		student.addStringProperty("IDCardNo");
		student.addStringProperty("ICCardNo");
		student.addStringProperty("DownloadTime");
		student.addStringProperty("Remark1");
		student.addStringProperty("Remark2");
		student.addStringProperty("Remark3");

		Entity studentItem = schema.addEntity("StudentItem");// StudentItem:生成的实体类类名
		studentItem.addLongProperty("StudentItemID").primaryKey().autoincrement();
		// studentItem.addLongProperty("StudentID").notNull();
		// Property studentItemProperty1 =
		// studentItem.addLongProperty("StudentID").notNull().getProperty();
		// studentItem.addLongProperty("ItemID").notNull();
		// Property studentItemProperty2 =
		// studentItem.addLongProperty("ItemID").notNull().getProperty();
		// ----修改学生成绩数据表
		studentItem.addStringProperty("studentCode");
		studentItem.addStringProperty("itemCode");

		studentItem.addIntProperty("lastResult");
		studentItem.addIntProperty("resultState");
		studentItem.addStringProperty("lastTestTime");
		studentItem.addIntProperty("TestState");
		studentItem.addStringProperty("Remark1");
		studentItem.addStringProperty("Remark2");
		studentItem.addStringProperty("Remark3");
		// 学生和项目与学生项目成绩之间分别建立一对多关系
		// studentItem.addToOne(student, studentItemProperty1);
		// student.addToMany(studentItem,
		// studentItemProperty1).setName("studentItems1");
		// studentItem.addToOne(item, studentItemProperty2);
		// item.addToMany(studentItem,
		// studentItemProperty2).setName("studentItems2");

		// studentItem实现序列化
		// studentItem.implementsSerializable();

		Entity roundResult = schema.addEntity("RoundResult");// RoundResult:生成的实体类类名
		roundResult.addLongProperty("RoundResultID").primaryKey().autoincrement();
		Property roundResultProperty = roundResult.addLongProperty("StudentItemID").notNull().getProperty();
		roundResult.addStringProperty("studentCode");
		roundResult.addStringProperty("itemCode");
		roundResult.addIntProperty("Result");
		roundResult.addIntProperty("RoundNo");
		roundResult.addStringProperty("TestTime");
		roundResult.addIntProperty("ResultState");
		roundResult.addIntProperty("IsLastResult");
		roundResult.addStringProperty("Mac");
		roundResult.addStringProperty("Remark1");
		roundResult.addStringProperty("Remark2");
		// 学生项目成绩和轮次成绩之间建立一对多关系
		roundResult.addToOne(studentItem, roundResultProperty);
		studentItem.addToMany(roundResult, roundResultProperty).setName("roundResults");

		Entity whRoundResult = schema.addEntity("WhRoundResult");// WhRoundResult:生成的实体类类名
		whRoundResult.addLongProperty("WhRoundResultID").primaryKey().autoincrement();
		whRoundResult.addStringProperty("studentCode");
		whRoundResult.addStringProperty("gradeCode");
		whRoundResult.addIntProperty("sex");
		whRoundResult.addStringProperty("hItemCode");
		whRoundResult.addStringProperty("wItemCode");
		whRoundResult.addIntProperty("hResult");
		whRoundResult.addIntProperty("wResult");
		whRoundResult.addIntProperty("RoundNo");
		whRoundResult.addStringProperty("TestTime");
		whRoundResult.addIntProperty("ResultState");
		whRoundResult.addStringProperty("Mac");

		Entity totalWhRoundResult = schema.addEntity("TotalWhRoundResult");// totalWhRoundResult:生成的实体类类名
		totalWhRoundResult.addLongProperty("WhRoundResultID").primaryKey().autoincrement();
		totalWhRoundResult.addStringProperty("studentCode");
		totalWhRoundResult.addStringProperty("gradeCode");
		totalWhRoundResult.addIntProperty("sex");
		totalWhRoundResult.addStringProperty("hItemCode");
		totalWhRoundResult.addStringProperty("wItemCode");
		totalWhRoundResult.addIntProperty("hResult");
		totalWhRoundResult.addIntProperty("wResult");
		totalWhRoundResult.addIntProperty("RoundNo");
		totalWhRoundResult.addStringProperty("TestTime");
		totalWhRoundResult.addIntProperty("ResultState");
		totalWhRoundResult.addStringProperty("Mac");

		Entity totalRoundResult = schema.addEntity("TotalRoundResult");// TotalRoundResult:生成的实体类类名
		totalRoundResult.addLongProperty("RoundResultID").primaryKey().autoincrement();
		Property totalRoundResultProperty = totalRoundResult.addLongProperty("StudentItemID").notNull().getProperty();
		totalRoundResult.addStringProperty("studentCode");
		totalRoundResult.addStringProperty("itemCode");
		totalRoundResult.addIntProperty("Result");
		totalRoundResult.addIntProperty("RoundNo");
		totalRoundResult.addStringProperty("TestTime");
		totalRoundResult.addIntProperty("ResultState");
		totalRoundResult.addIntProperty("IsLastResult");
		totalRoundResult.addStringProperty("Mac");
		totalRoundResult.addStringProperty("Remark1");
		totalRoundResult.addStringProperty("Remark2");
		// 学生项目成绩和轮次成绩之间建立一对多关系
		totalRoundResult.addToOne(studentItem, totalRoundResultProperty);
		studentItem.addToMany(totalRoundResult, totalRoundResultProperty).setName("totalRoundResults");

		// roundResult实现序列化
		// roundResult.implementsSerializable();
		// item表中的主键为studentItem表中的外键
		// studentItem.addToOne(item, studentItemProperty);

		// school表中的主键为grade表中的外键
		// grade.addToOne(school, gradeProperty);

		// grade表中的主键为classes表中的外键
		// classes.addToOne(grade, classesProperty);

		// student表中的主键为studentItem表中的外键
		// studentItem.addToOne(student, studentItemProperty1);

		// studentItem表中的主键为roundResult表中的外键
		// roundResult.addToOne(studentItem, roundResultProperty);

	}

}
