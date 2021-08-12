using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace PRN292_Project.Entity
{
    class TestCaseData
    {
        private string questionNo;
        private List<string> inputs;
        private string output;
        private float mark;

        public TestCaseData(string questionNo, List<string> inputs, string output, float mark)
        {
            this.QuestionNo = questionNo;
            this.Inputs = inputs;
            this.Output = output;
            this.Mark = mark;
        }

        public string QuestionNo { get => questionNo; set => questionNo = value; }
        public List<string> Inputs { get => inputs; set => inputs = value; }
        public string Output { get => output; set => output = value; }
        public float Mark { get => mark; set => mark = value; }
    }
}
