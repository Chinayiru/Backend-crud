import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/Manage.vue'
// import Store from "@/store"

Vue.use(VueRouter)

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "about" */ '../views/Login.vue')
  },
  {
    path: '/register',
    name: 'register',
    component: () => import(/* webpackChunkName: "about" */ '../views/register.vue')
  },
  {
    path: '/',
    component: () => import('../views/Manage.vue'),
    redirect:'/home',
    children: [
      {path: 'home', name: '首页', component: () => import('../views/Home.vue')},
      {path: 'user', name: '用户管理', component: () => import('../views/User.vue')},
      {path: 'role', name: '角色管理', component: () => import('../views/Role.vue')},
      {path: 'person', name: '个人信息', component: () => import('../views/Person.vue')},
      // {path: 'menu', name: '菜单管理', component: () => import('../views/Menu.vue')},
    ]
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// //路由守卫
// router.beforeEach((to,from,next) =>{
//   localStorage.setItem("currentPathName",to.name)//设置当前路由名称
//   store.commit("setPath")//触发store的数据更新
//   next()//放行路由
// })

export default router
