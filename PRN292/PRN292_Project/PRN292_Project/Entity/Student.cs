using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PRN292_Project
{
    class Student
    {
        private string id;
        private string name;

        public Student(string id, string name)
        {
            this.Id = id;
            this.Name = name;
        }

        public string Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
    }
}
