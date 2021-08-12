using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PRN292_Project.Entity
{
    class Exam
    {
        private string id;
        private string name;
        private DateTime date;

        public Exam(string id, string name, DateTime date)
        {
            this.Id = id;
            this.Name = name;
            this.Date = date;
        }

        public string Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public DateTime Date { get => date; set => date = value; }
    }
}
