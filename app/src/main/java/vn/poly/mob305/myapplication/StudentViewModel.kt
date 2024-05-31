package vn.poly.mob305.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudentViewModel : ViewModel() {
    private val _students = MutableLiveData<MutableList<Student>?>()
    val students: MutableLiveData<MutableList<Student>?> = _students

    init {
        // Khởi tạo dữ liệu mẫu
        val initialStudents = mutableListOf<Student>()
        for (i in 1..10) {
            initialStudents.add(Student("Student $i", i))
        }
        _students.value = initialStudents
    }

    fun removeStudent(student: Student) {
        val updatedList = _students.value?.toMutableList()
        updatedList?.remove(student)
        _students.value = updatedList
    }

    fun updateStudentName(student: Student, newName: String) {
        val updatedList = _students.value?.toMutableList()
        val index = updatedList?.indexOf(student)
        index?.let {
            updatedList[it].name = newName
            _students.value = updatedList
        }
    }
}
