using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PRN292_Project.Entity
{
    class Result
    {
        private string studentId;
        private string studentName;
        private float mark;

        public Result(string studentId, string studentName, float mark)
        {
            this.StudentId = studentId.ToUpper();
            this.StudentName = studentName;
            this.Mark = mark;
        }

        public string StudentId { get => studentId; set => studentId = value; }
        public string StudentName { get => studentName; set => studentName = value; }
        public float Mark { get => mark; set => mark = value; }
    }
}
