using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace PRN292_Project.DAO
{
    class StudentDAO
    {
        public static int addStudent(string id, string name)
        {
            string sql = "insert into Student values(@id, @name)";
            SqlParameter[] parameters = new SqlParameter[2];
            SqlParameter paramId = new SqlParameter("@id", id);
            SqlParameter paramName = new SqlParameter("@name", name);
            parameters[0] = paramId;
            parameters[1] = paramName;
            int result = Database.executeSQL(sql, parameters);
            return result;
        }

        public static DataTable getAllStudent()
        {
            string sql = "select * from Student";
            DataTable dataTable = Database.getDataBySQL(sql);
            return dataTable;
        }

        public static Student getStudentById(string studentId)
        {
            string sql = "select * from Student where id = '" + studentId + "'";
            DataTable dataTable = Database.getDataBySQL(sql);
            if (dataTable.Rows.Count != 0)
            {
                DataRow row = dataTable.Rows[0];
                string id = row["id"].ToString();
                string name = row["name"].ToString();
                Student s = new Student(id, name);
                return s;
            }
            return null;
        }

        public static int addExam(string semester, string studentId, float mark, DateTime date)
        {
            string sql = "insert into Exam values(@semester, @studentId, @mark, @date)";
            SqlParameter[] parameters = new SqlParameter[4];
            SqlParameter paramSemester = new SqlParameter("@semester", semester);
            SqlParameter paramStudentId = new SqlParameter("@studentId", studentId);
            SqlParameter paramMark = new SqlParameter("@mark", mark);
            SqlParameter paramDate = new SqlParameter("@date", date);
            parameters[0] = paramSemester;
            parameters[1] = paramStudentId;
            parameters[2] = paramMark;
            parameters[3] = paramDate;
            int result = Database.executeSQL(sql, parameters);
            return result;
        }

        public static DataTable getAllResult()
        {
            string sql = "Select s.id as 'StudentId', e.semester as 'Semester', s.name as 'StudentName', e.Mark, e.Date" +
               " from Student s, Exam e" +
               " where s.id = e.StudentId";
            DataTable dataTable = Database.getDataBySQL(sql);
            return dataTable;
        }

        public static DataTable getAllResultBySemester(string semester)
        {
            string sql = "Select s.id as 'StudentId', e.semester as 'Semester', s.name as 'StudentName', e.Mark, e.Date" +
               " from Student s, Exam e" +
               " where s.id = e.StudentId and semester = '" + semester + "'";
            DataTable dataTable = Database.getDataBySQL(sql);
            return dataTable;
        }

        public static DataTable getAllSemester()
        {
            string sql = "Select distinct semester from Exam";
            DataTable dataTable = Database.getDataBySQL(sql);
            return dataTable;
        }

    }
}
